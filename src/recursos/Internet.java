/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import static org.jsoup.Jsoup.connect;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import visao.Busca;

/**
 *
 * @author thyago
 */
public class Internet {
    static final String agente              = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)";
    static final String referencia          = "http://www.google.com";
    static final int    tempo               = 0;
    static final String MASCARA_TELEFONE    = "\\([0-9]{2}?\\)[0-9]{4}?\\-[0-9]{4}?";
    static final String MASCARA_TELEFONE2   = "\\([0-9]{2}?\\) [0-9]{4}?\\-[0-9]{4}?";
    static final String MASCARA_CEP         = "\\([0-9]{2}?\\)[0-9]{4}?\\-[0-9]{4}?";
    static final String MASCARA_CEP2        = "\\([0-9]{2}?\\) [0-9]{4}?\\-[0-9]{4}?";    
    static final String ARROBA              = "@";
    List<Busca>  lista                      = new ArrayList<>(100);
    Busca        busca                      = new Busca();
    
    /**
     *
     * @param site
     * @return
     */
    public Document conectarSite(String site){
        if(site != null && !site.isEmpty()){
            try {
                return connect(site.trim()).timeout(tempo).userAgent(agente).referrer(referencia).get();
            } catch (IOException ex) {
                try {
                    return Jsoup.parse(new URL(site.trim()), tempo);
                } catch (MalformedURLException ex1) {
                    ex1.getMessage();
                    return null;
                } catch (IOException ex1) {
                    ex1.getMessage();
                    return null;
                }
            }
        }
        return null;
    }
    
    /**Pega links qualquer
     * @param site daonde quer pegar os links
     * @return links do site pesquisado*/
    public Elements pegaLinks(String site){
        Document document = conectarSite(site);
        if(document != null){
            return document.select("a[href]").not("img[src]").not("script[src]")
                    .not("link[href]").not("style").not("title").not("meta[name]")
                    .not("br").not(".sw_hdr_bg").not("#sb_foot").not(".sw_logo")
                    .not("object").not(".sb_meta").not("#tw").not(".sw_a")
                    .not("#mngb").not("#foot").not("#footcnt").not("#top_nav").not(".s")
                    .not("#lu_pinned_rhs").not("#cst").not("#imagebox_bigimages")
                    .not("#rhs_block").not(".st").not(".osl").not("#extrares").not("em").not(".mw"); 
        }else{ 
            return null;
        }
    }
    
    /**Pega emails de determinado link
     * @param site para onde pegar emails
     * @return links de e-mail
     */
    public Elements pegaEmails(String site){
        Document document = conectarSite(site);
        if(document != null){
            return document.getElementsMatchingOwnText("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$").not("img[src]")
                    .not("script[src]").not("link[href]").not("style").not("title")
                    .not("meta[name]").not("br").not("#menu").not("object").not(".logo")
                    .not(".gsc-search-box").not("#google_translate_element").not(".fb-like-box .fb_iframe_widget")
                    .not("#banner").not("#fb-root").not("#google_image_div").not("#navigation").not("nav")
                    .not("#TwitterCounter").not("#menu").not("#cssmenu").not("#container_destaque");
        }else{
            return null;
        }
    }
    
    /**remove acentuação de String
     * @param palavra para retirar acentuação
     * @return retorna palavra sem acentuação*/
    public String removerAcentos(String palavra) {
        CharSequence cs = new StringBuilder(palavra);
        return Normalizer.normalize(cs, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }   
   
    /**
     *
     * @param url
     * @return
     */
    public String pegaTelefone(String url){
        String res = conectarSite(url).getElementsMatchingText(MASCARA_TELEFONE).text().replace("-(", "(").replaceAll("[a-zA-Z]", "");
        if(res == null || res.isEmpty()){
            res = conectarSite(url).getElementsMatchingText(MASCARA_TELEFONE2).text().replace("-(", "(").replaceAll("[a-zA-Z]", "");
        }
        if(res != null && !res.isEmpty() && res.length() >= 8){
            res = removerAcentos(res);
            res = res.replace(ARROBA, "").replace(":", "").replace(",", "").replace("()", "").replace(".", "").replace("/", "").replace(") ", ")").replace(" 11 ", " (11)");
            String ltelefone[];
            if(!res.contains("+") && !res.contains("$")){
                ltelefone = res.split(" ");
            }else{
                ltelefone = res.split(" +");
            }
            for (String ltelefone1 : ltelefone) {
                if (ltelefone1 != null && !ltelefone1.isEmpty() && ltelefone1.length() >= 8 && ltelefone1.length() <= 16 && ltelefone1.contains("(") && ltelefone1.contains(")")) {
                    return ltelefone1;
                }
            }
            return "Não achou!";
        }  
        return null;
    }

    /**
     *
     * @param url
     * @return
     */
    public String pegaCep(String url){
        String res = conectarSite(url).getElementsMatchingText(MASCARA_CEP).text().replaceAll("[a-zA-Z]", "");
        if(res == null || res.isEmpty()){
            res = conectarSite(url).getElementsMatchingText(MASCARA_CEP2).text().replaceAll("[a-zA-Z]", "");
        }
        if(res != null && !res.isEmpty() && res.length() >= 8){
            res = removerAcentos(res);
            res = res.replace(ARROBA, "").replace(":", "").replace(",", "").replace("()", "").replace(".", "").replace("/", "").replace(") ", "");
            String lcep[];
            if(!res.contains("+") && !res.contains("$")){
                lcep = res.split(" ");
            }else{
                lcep = res.split(" +");
            }
            for (String lcep1 : lcep) {
                if (lcep1 != null && !lcep1.isEmpty() && lcep1.length() >= 8 && lcep1.length() <= 16 && lcep1.contains("(") && lcep1.contains(")")) {
                    return lcep1;
                }
            }
            return "Não achou!";
        }  
        return null;
    }    
    
}

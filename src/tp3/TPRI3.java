/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;

/**
 *
 * @author jgmorenof
 */
public class TPRI3 {

	/**
	 * @param args the command line arguments
	 */
	String nameFileXML;
	String nameFolderIndex;
	String[] result;

	public TPRI3() {
		nameFileXML = "simplewiki.csv";
		nameFolderIndex = "C:\\Users\\Diego\\git\\TP3RI\\indexRI\\";
	}

	public static void main(String[] args) {
		TPRI3 wfr = new TPRI3();
        wfr.index();  // pas besoin de recréer l'index si on n'a pas modifié l'algo de recherche
        System.out.println("index done");
//		ArrayList<String> titles = new ArrayList<String>();
//		titles.add("Paris");
////		titles.add("Rose");
//
//		ArrayList<String> texts = new ArrayList<String>();
//		texts.add("Paris");
//
//		String[] a = wfr.query2(titles, texts); // recherche full titles
//		for (int i = 0; i < a.length; i++) {
//			System.out.println("here" + a[i]);
//		}
	}

	public void index() {
		IndexCollection mywikipedia = new IndexCollection(nameFileXML, nameFolderIndex);
		try {
			mywikipedia.index();
		} catch (Exception ex) {
			Logger.getLogger(TPRI3.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public String[] query(String query, String query2, String query3) {
		QuerySimple qs = new QuerySimple(nameFolderIndex);
		try {
			result = qs.process(query, query2, query3);
		} catch (Exception ex) {
			Logger.getLogger(TPRI3.class.getName()).log(Level.SEVERE, null, ex);
		}
		return result;
	}

	public String[] query2(ArrayList<String> titles, ArrayList<String> texts) {
		QuerySimple qs = new QuerySimple(nameFolderIndex);
		try {
			result = qs.process2(titles, texts);
		} catch (Exception ex) {
			Logger.getLogger(TPRI3.class.getName()).log(Level.SEVERE, null, ex);
		}
		return result;
	}
}

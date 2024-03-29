/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;


/**
 *
 * @author jgmorenof
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import tp2.idf.*;
import tp2.tf.*;



public class QuerySimple {

    String filename;
    String titleString;
    String indexPath;

    public QuerySimple(String indexPath) {
        this.indexPath = indexPath;
    }

    public void process(String querystr) throws IOException, ParseException {
        StandardAnalyzer analyzer = new StandardAnalyzer();
        Path path = new File(indexPath).toPath();
        Directory index = FSDirectory.open(path);

        Query q = new QueryParser( "title", analyzer).parse(querystr);

        int hitsPerPage = 5;
        IndexReader reader = DirectoryReader.open(index);
        
        IndexSearcher searcher = new IndexSearcher(reader);
        
        //searcher.setSimilarity(new BM25Similarity(1.2f, 0.25f)); //Avec BM25
        //searcher.setSimilarity(new BM11Similarity(1.2f)); //Avec BM11
        //searcher.setSimilarity(new BM15Similarity(1.2f)); //Avec BM15
       

        //searcher.setSimilarity(new TF_IDF(new TF_Total(), new IDF_Total())); //Avec TFtotal, IDFtotal
        //searcher.setSimilarity(new TF_IDF(new TF_Total(), new IDF_Sum())); //Avec TFtotal, IDFsum
        //searcher.setSimilarity(new TF_IDF(new TF_Total(), new IDF_Sum_Smooth())); //Avec TFtotal, IDFsum,smooth
        //searcher.setSimilarity(new TF_IDF(new TF_Total(), new IDF_BIR())); //Avec TFtotal, IDFbir
        //searcher.setSimilarity(new TF_IDF(new TF_Total(), new IDF_BIR_Smooth())); //Avec TFtotal, IDFbir, smooth
        //searcher.setSimilarity(new TF_IDF(new TF_Log(), new IDF_Total())); //Avec TFlog, IDFtotal
        //searcher.setSimilarity(new TF_IDF(new TF_Log(), new IDF_Sum())); //Avec TFlog, IDFsum
        //searcher.setSimilarity(new TF_IDF(new TF_Log(), new IDF_Sum_Smooth())); //Avec TFlog, IDFsum,smooth
        //searcher.setSimilarity(new TF_IDF(new TF_Log(), new IDF_BIR())); //Avec TFlog, IDFbir
        searcher.setSimilarity(new TF_IDF(new TF_Log(), new IDF_BIR_Smooth())); //Avec TFlog, IDFbir,smooth
        
        TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, hitsPerPage+20);
        searcher.search(q, collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;
        System.out.println("Found " + hits.length + " hits of "+collector.getTotalHits()+".");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("title") );
        }

        reader.close();
    }
}

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

//        DataManager dataManager = new DataManager(path, keyLabels, labelTag, startingTag);

public class DataManager {
    private ArrayList<Article> articleList;
    private ArrayList<Article> trainingArticleList;
    private ArrayList<Article> testingArticleList;
    private ArrayList<String> keyLabels;

    public DataManager(Path path, ArrayList<String> keyLabels, String labelsTag, String startingTag) throws IOException {
        this.keyLabels=keyLabels;
        importArticles(path, labelsTag.toUpperCase(), 20.0, startingTag);
    }

    private void importArticles(Path path, String labelTag, Double trainingPercent, String startingTag){
        articleList = new ArrayList<>();
        testingArticleList =new ArrayList<>();
        trainingArticleList = new ArrayList<>();
        ImportArticles importer = new ImportArticles(articleList);
        importer.extract(path, labelTag, startingTag);
        for(Article article:articleList){
            if(!keyLabels.contains(article.getLabel())){
                article.setLabel("unknown");
            }
        }
        Double tmp = Double.valueOf(articleList.size())*trainingPercent;
        Integer trainingSetSize = tmp.intValue();
        for(int i=0;i<articleList.size();++i){
            if(i<trainingSetSize) {
                trainingArticleList.add(articleList.get(i));
            }
            else{
                testingArticleList.add(articleList.get(i));
            }
        }
    }

    private void importArticles(Path path, String featureTag, String labelTag, Double trainingPercent, String startingTag, String splitter){
        articleList = new ArrayList<>();
        testingArticleList =new ArrayList<>();
        trainingArticleList = new ArrayList<>();
        ImportArticles importer = new ImportArticles(articleList);
        importer.extract(path, labelTag, startingTag);
        for(Article article:articleList){
            if(!keyLabels.contains(article.getLabel())){
                article.setLabel("unknown");
            }
        }
        Double tmp = Double.valueOf(articleList.size())*trainingPercent;
        Integer trainingSetSize = tmp.intValue();
        for(int i=0;i<articleList.size();++i){
            if(i<trainingSetSize) {
                trainingArticleList.add(articleList.get(i));
            }
            else{
                testingArticleList.add(articleList.get(i));
            }
        }
    }
}

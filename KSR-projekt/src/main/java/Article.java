import java.util.*;

public class Article {

    private String text;
    private String label;
    private String knnLabel;
    private String featureString;
    private ArrayList<String> words;
    private ArrayList<String> terms;

    public Article(TreeMap<String, ArrayList<String>> articleData){

        if(articleData.containsKey("LABEL")){
            this.label=articleData.get("LABEL").get(0);}
        else{
            this.label="unknown";}

        if(articleData.containsKey("TEXT")){
            this.text = articleData.get("TEXT").get(0);}
        else{
            this.text=" ";}
        if(articleData.containsKey("FEATURE")){
            this.featureString = articleData.get("FEATURE").get(0);}
        else{
            this.featureString = " ";}
    }


    public String getText() {
        return text;
    }

    public String getLabel() {
        return label;
    }

    public String getFeatureString() {
        return featureString;
    }

    public void setFeatureString(String featureString) {
        this.featureString = featureString;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words=new ArrayList<>();
        for(String word: words){ this.words.add(word);}
    }

    public ArrayList<String> getTerms() {
        return terms;
    }

    public void setTerms(ArrayList<String> terms) {
        this.terms = new ArrayList<>();
        for(String word: terms){ this.terms.add(word);}
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getKnnLabel() {
        return knnLabel;
    }

    public void setKnnLabel(String knnLabel) {
        this.knnLabel = knnLabel;
    }

    @Override
    public String toString() {
        return "Article{" +
                //"text=" + text + '\n' +
                ", label=" + label + '\n' +
                ", knnLabel=" + knnLabel + '\n' +
                ", featureString=" + featureString + '\n' +
                //", words=" + words + '\n' +
                //", terms=" + terms + '\n' +
                '}';
    }
}
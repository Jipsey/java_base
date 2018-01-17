public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer  {

    private String [] keyWords = {":(","=(",":|"};
    private String text;

    @Override
    public Label processText(String text) {
        this.text = text;
        return getLabel();
    }


    @Override
    protected String[] getKeyWords() {
        return keyWords;
    }

    @Override
    protected Label getLabel() {

        for (String s : getKeyWords() )
        {
            if(text.contains(s))
                return Label.NEGATIVE_TEXT;
        }

        return Label.OK;
    }
}

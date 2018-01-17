class Main {

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {

        for (TextAnalyzer ta: analyzers ) {
          if(ta.processText(text) != Label.OK )
             return ta.processText(text);
        }

        return Label.OK;
    }

    public abstract class KeywordAnalyzer implements TextAnalyzer{

        @Override
        public Label processText(String text) {
            return null;
        }

        protected abstract String[] getKeywords();

        protected abstract  Label getLabel();
    }


    public class TooLongTextAnalyzer implements TextAnalyzer {

        private int maxLength;

        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            if ( text.length() <= maxLength)
                return Label.OK;
            return Label.TOO_LONG;
        }
    }

    public class SpamAnalyzer extends KeywordAnalyzer {

        private String[] keywords;
        private String text;
        public SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {

            for (String s : getKeywords())
            {
                if (text.contains(s))
                    return Label.SPAM;
            }
            return Label.OK;
        }

        @Override
        public Label processText(String text) {
            this.text = text;
            return getLabel();
        }
    }

    public class NegativeTextAnalyzer extends KeywordAnalyzer  {

        private String [] keyWords = {":(","=(",":|"};
        private String text;

        @Override
        public Label processText(String text) {
            this.text = text;
            return getLabel();
        }


        @Override
        protected String[] getKeywords() {
            return keyWords;
        }

        @Override
        protected Label getLabel() {

            for (String s : getKeywords() )
            {
                if(text.contains(s))
                    return Label.NEGATIVE_TEXT;
            }

            return Label.OK;
        }
    }
}

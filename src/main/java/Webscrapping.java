import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/** this program is trying to get information of the website.*/
public class Webscrapping {
    /** main statement.
     *
     * @param args is the argument.
     */
    public static void main(final String[] args) {
        int wordCount = 0;
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        String input = urlToString("http://erdani.com/tdpl/hamlet.txt");
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' '  && input.charAt(i+1) != ' ') {
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }
    /**helper function to scan the document.
     *
     * @param url is the url of the website.
     * @return the content of the website.
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}

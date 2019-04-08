import com.ibm.icu.text.Transliterator;

/**
 * Created by Ivan Chaykin
 * Date: 04.04.2019
 * Time: 14:37
 */
public class Transcriptor {
    public static final String CYRILLIC_TO_LATIN = "Cyrillic-Latin";
    public static final String LATIN_TO_CYRILLIC = "Latin-Cyrillic";

    public static void main(String[] args) {
        String stLatin = "привет мир";
        String stCyrillic = "Kopu v yibkah";

        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        String resultLatin = toLatinTrans.transliterate(stLatin);
        System.out.println(resultLatin);

        Transliterator toCyrillicTrans = Transliterator.getInstance(LATIN_TO_CYRILLIC);
        String resultCyrillic = toCyrillicTrans.transliterate(stCyrillic);
        System.out.println(resultCyrillic);
    }
}

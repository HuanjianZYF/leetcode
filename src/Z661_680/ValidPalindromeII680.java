package Z661_680;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/19 21:31
 **/
public class ValidPalindromeII680 {

    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII680().validPalindrome("vxbljyyvfqjvbfmqvrvbffseoihrkjezzbxesmiumgyadcrdyelhvliymdpzzryjezklfcjaqcfrfgbgykujbsnpehuensdruexbocpluhoagbbbotvypzboyraldceguaqnveahzxyjosldfwtehonldywseonznxmwlwmxjqpsevxaexeeyrexevozbbzdhfkmgiamoyaczkhnvkdwxgoigdsqnvoeorkqegjtgtxmkbjbmhcyhipvngimbovxqaklskibicmxhctorxwzsnrblkdzmelrdetgoffauzldmtzyeaulhbnzkifeunxqeuftwetlmxyksrmykfuvumgiifqaijfqyododzvwvuyoyihtjhzgofhgxwykssuchxdqlepphetiremmsamgqobhnwmkhzweslckkwcoauxbobeplqkpcfpcukbhucgyrwjpwmfzhitdamuavzhumfdxhwlmgcnsoiudwdhdkrybzdnierzcdsuowfxritwbzkzhlsjevouikjoxpsdnedzlcvzyhhxpvgxcmfmczgoflebeurqjddnevsreuclhnggrtcpsoadyzryoeutgjnuavghvuxtywicmnhqtzdxvvnvlrylftfufxqokqyhtydzljrqzvuvxggzgokkoqjrvcsexkxssukbrijbvggsrhrnaavkamrtmtabqyfyklreoppweplnclgeqrefsqvnkjphelqmrftpsekqnecfunuiznuurpksmmdqxfdaqczgtynhxnfculicerndrnszkefupeimnkafitkwyczerwxrikkuiarscxjtbvnulyctqltrzthvdaxbxhrzmhoqksgwxresnjwmmolmcplopobeurzfibipbhnamsojemextlbyfswtgtxjaiolptvjpredtliaydrxbthvpvqxpvukjdfpkgmftnhvmvhlncpdlyspysthfshvmqzwucpfgsivpworhizjitjj"));
    }

    public boolean validPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return true;
        }

        for (int i = 0 ; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                String str1 = s.substring(0, i);
                String str2 = s.substring(i + 1, len);
                if (isPalindrome(str1 + str2)) {
                    return true;
                }

                String str3 = s.substring(0, len - 1 - i);
                String str4 = s.substring(len - i, len);
                if (isPalindrome(str3 + str4)) {
                    return true;
                }
                return false;
            }
        }

        return true;
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return true;
        }
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

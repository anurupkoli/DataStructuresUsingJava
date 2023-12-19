package LinearSearch;

public class SearchInStrings {
    static boolean searchInString(String str, char c){
        if(str.length()==0){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if(c==(str.toCharArray()[i])){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "Anurup";
        System.out.println(searchInString(str, 'A'));
    }
}

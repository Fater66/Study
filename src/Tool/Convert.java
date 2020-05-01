package Tool;

public class Convert {

    public String convertSquaretoBrace(String origin)
    {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<origin.length();i++)
        {
            if(origin.charAt(i) == '[')
                sb.append("{");
            else if (origin.charAt(i) == ']')
                sb.append("}");
            else sb.append(origin.charAt(i));
        }
        return sb.toString();
    }
}

package jZOffer;

import java.util.LinkedList;

public class strfirst {

	/**
	 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
	 * @param args
	 */
	public static void main(String[] args) {
		Integer.valueOf(1);
		// TODO Auto-generated method stub

		strfirst s=new strfirst();
		s.Insert('g');
		s.Insert('o');
		s.Insert('o');
		s.Insert('g');
		s.Insert('l');
		s.Insert('e');
		System.out.println(s.FirstAppearingOnce());
	}
	//Insert one char from stringstream
    char insertchar=' ';
    char first='#';
    LinkedList l=new LinkedList<>();
    public void Insert(char ch)
    {
    	insertchar+=ch;
        if(l.isEmpty()){
            l.add(ch);
            first=(char) l.get(0);
        }else{
            l.add(ch);
            if(ch==(char)l.get(0)){
                l.remove(0);
                first=(char)l.get(0);
            }
        }
        
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    return first;
    }

}

package neal.java.effectivejava._2objects;

import java.io.*;

public class _9 {


    //	try-finally	-	No	longer	the	best	way	to	close	resources!
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch(IOException e){
                   e.printStackTrace();
                }
            }
            /**
             * wrong: may cause exception
             */
            //br.close();
        }
    }

    //	try-finally	is	ugly	when	used	with	more	than	one	resource!
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[1024];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }


    //	try-with-resources	-	the	the	best	way	to	close	resources!
    static	String	firstLineOfFileCloseable(String	path)	throws	IOException	{
        try	(BufferedReader	br	=	new	BufferedReader(
                new	FileReader(path)))	{
            return	br.readLine();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //	try-with-resources	on	multiple	resources	-	short	and	sweet
    static	void	copyCloseable(String	src,	String	dst)		{
        try	(InputStream	in	=	new	FileInputStream(src);
                OutputStream	out	=	new	FileOutputStream(dst))	{
            byte[]	buf	=	new	byte[100];
            int	n;
            while	((n	=	in.read(buf))	>=	0)
                out.write(buf,	0,	n);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {

        copyCloseable("1","2");

    }
}

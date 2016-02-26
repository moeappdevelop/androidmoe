package Common;

import android.os.Environment;

import java.io.FileOutputStream;

/**
 * Created by timeloveboy on 16/2/27.
 */
public class File {
    public static void saveSDcard(String filepath,byte[] buffer){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            java.io.File sdCardDir = Environment.getExternalStorageDirectory();//获取SDCard目录
            java.io.File saveFile = new java.io.File(sdCardDir,filepath);
            FileOutputStream outStream;
            try {
                outStream= new FileOutputStream(saveFile);
                outStream.write(buffer);
                outStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                
            }


        }
    }
}

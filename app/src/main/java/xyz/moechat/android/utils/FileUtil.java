package xyz.moechat.android.utils;

import android.os.Environment;

import java.io.FileOutputStream;

/**
 * Created by timeloveboy on 16/2/27.
 */
/**
 * Created by timeloveboy on 16/3/29.
 */
public class FileUtil {
    public static void saveSD(String filename,byte[] bytes){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){

            File sdCardDir = Environment.getExternalStorageDirectory();//获取SDCard目录

            File saveFile = new File(sdCardDir, GlobalParams.FolderPath+filename);

            try {
                FileOutputStream outStream = new FileOutputStream(saveFile);
                outStream.write(bytes);
                outStream.close();

            }
            catch (Exception e){
            }
        }
    }

    public static byte[] Bitmaptobytes(Bitmap bmp){
        int size     = bmp.getRowBytes() * bmp.getHeight();
        ByteBuffer b = ByteBuffer.allocate(size);

        bmp.copyPixelsToBuffer(b);

        byte[] bytes = new byte[size];

        try {
            b.get(bytes, 0, bytes.length);
        } catch (BufferUnderflowException e) {
            // always happens
        }
        return bytes;
    }

    public static byte[] BitmaptoPng(Bitmap bmp){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
    public static boolean Get2MakeFolder(String folderpath){
        File folder = new File(folderpath);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
    }

}

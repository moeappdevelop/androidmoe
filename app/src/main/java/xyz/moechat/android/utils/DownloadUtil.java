public class DownloadUtil {
    public static long DownloadBookMedia(Context context,String mediaUrl, String mediaFolder,String mediaName){
        DownloadManager downloadManager = (DownloadManager)context.getSystemService(context.DOWNLOAD_SERVICE);

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(mediaUrl));

        FileUtil.Get2MakeFolder(mediaFolder);
        request.setDestinationInExternalPublicDir(mediaFolder,mediaName);

        request.setTitle("有书:"+mediaFolder);
        request.setDescription("有书:"+mediaName);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        long downloadId = downloadManager.enqueue(request);
        return downloadId;
    }
}
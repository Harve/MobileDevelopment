package parker.david.labs;

import android.graphics.Bitmap;

public class Item {
    private  String mTitle;
    private  String mLink;
    private  String mDate;
    private  String mDescription;
    private  String mImageUrl;
    private  Bitmap mImage;

    public  Item(String pTitle,String pLink,String pDate,String pDescription){
        setTitle(pTitle);
        setLink(pLink);
        setDate(pDate);
        setDescription(pDescription);
    }
    public Bitmap getImage(){return mImage;}
    public void setImage(Bitmap pImage){mImage = pImage;}
    public String getImageUrl(){return mImageUrl;}
    public void setImageUrl(String pImageUrl){mImageUrl=pImageUrl;}
    public String getTitle(){return mTitle;}
    public void setTitle(String pTitle){mTitle=pTitle;}
    public String getLink(){return mLink;}
    public void setLink(String pLink){mLink=pLink;}
    public String getDate(){return mDate;}
    public void setDate(String pDate){mDate=pDate;}
    public String getDescription(){return mDescription;}
    public void setDescription(String pDescription){mDescription=pDescription;}
}

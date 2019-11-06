package com.example.pointearning.ui.main;

import android.Manifest;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;
import com.example.pointearning.zxing.util.Constant;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人资料设置
 */
public class PersonalSettingsActivity extends BaseActivity {


    private static final int REQUEST_CODE_SCAN_GALLERY = 100;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.touxiang)
    TextView touxiang;
    @BindView(R.id.icon)
    SimpleDraweeView icon;
    @BindView(R.id.nicheng)
    TextView nicheng;
    @BindView(R.id.nichengshezhi)
    TextView nichengshezhi;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.sexweishezhi)
    TextView sexweishezhi;
    @BindView(R.id.birthday)
    TextView birthday;
    @BindView(R.id.birthdaynosetting)
    TextView birthdaynosetting;
    @BindView(R.id.gerenqianming)
    TextView gerenqianming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_settings);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.touxiang, R.id.icon, R.id.nicheng, R.id.nichengshezhi, R.id.sex, R.id.sexweishezhi, R.id.birthday, R.id.birthdaynosetting, R.id.gerenqianming})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.touxiang:
                break;
            case R.id.icon:
                // 申请文件读写权限（部分朋友遇到相册选图需要读写权限的情况，这里一并写一下）
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    // 申请权限
                    ActivityCompat.requestPermissions(PersonalSettingsActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Constant.REQ_PERM_EXTERNAL_STORAGE);
                }

                if (ContextCompat.checkSelfPermission(PersonalSettingsActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PersonalSettingsActivity.this, new
                            String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    //打开系统相册
                    openAlbum();
                }
                break;
            case R.id.nicheng:
                break;
            case R.id.nichengshezhi:
                break;
            case R.id.sex:
                break;
            case R.id.sexweishezhi:
                break;
            case R.id.birthday:
                break;
            case R.id.birthdaynosetting:
                break;
            case R.id.gerenqianming:
                break;
        }
    }

    private void openAlbum() {

        //打开手机中的相册
        Intent innerIntent = new Intent(Intent.ACTION_GET_CONTENT); //"android.intent.action.GET_CONTENT"
        innerIntent.setType("image/*");
        startActivityForResult(innerIntent, REQUEST_CODE_SCAN_GALLERY);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


            //照片回调
            if (resultCode == RESULT_OK&&requestCode == REQUEST_CODE_SCAN_GALLERY&&null!=data) {

                if (Build.VERSION.SDK_INT >= 19) {
                    handleImageOnKitkat(data);
                } else {
                    handleImageBeforeKitkat(data);
                }



            }


    }

    private void handleImageBeforeKitkat(Intent data) {

        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayImage(imagePath);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void handleImageOnKitkat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this, uri)) {
            //如果是document类型的uri，则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content:" +
                        "//downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            //如果是content类型的uri，则使用普通方式处理
            imagePath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            //如果是File类型的uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        displayImage(imagePath);//根据图片路径显示图片
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Constant.REQ_PERM_EXTERNAL_STORAGE:
                // 文件读写权限申请
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 获得授权
                    // 申请文件读写权限（部分朋友遇到相册选图需要读写权限的情况，这里一并写一下）
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        // 申请权限
                        ActivityCompat.requestPermissions(PersonalSettingsActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Constant.REQ_PERM_EXTERNAL_STORAGE);
                        return;
                    }
                } else {
                    // 被禁止授权
                    Toast.makeText(PersonalSettingsActivity.this, "请至权限中心打开本应用的文件读写权限", Toast.LENGTH_LONG).show();
                }
                break;
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                } else {
                    if (ContextCompat.checkSelfPermission(PersonalSettingsActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(PersonalSettingsActivity.this, new
                                String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    }
                    Toast.makeText(this, "没有给权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    private String getImagePath(Uri uri, String selection) {
        String path = null;
        //通过uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImage(String imagePath) {
        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);

            Uri uri = Uri.parse("file://xxxxx"+imagePath);//file://包名(实践证明随便填什么都可以)


            Log.i("imagePath",imagePath);
            //
            RoundingParams rp = new RoundingParams();
            rp.setBorder(getResources().getColor(R.color.planbook_default),3);
            rp.setRoundAsCircle(true);
            icon.getHierarchy().setRoundingParams(rp);
            icon.setImageURI(uri);

//            icon.setImageBitmap(bitmap);
        } else {
            Toast.makeText(this, "获取图片失败", Toast.LENGTH_SHORT).show();
        }
    }
}

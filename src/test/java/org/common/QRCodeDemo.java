package org.common;

import java.io.File;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeDemo {
	
	public void create() throws Exception{
		
		try {
            String str = "CN:男;COP:公司;ZW:职务";// 二维码内容
            String path = "E:\\Chrysanthemum.jpg";
            BitMatrix byteMatrix;
            byteMatrix = new MultiFormatWriter().encode(
                 // 在Zxing转码之前，手动转码，避免了中文乱码的错误
                    new String(str.getBytes(), "iso-8859-1"),
                 BarcodeFormat.QR_CODE, 200, 200);
            File file = new File(path);

            MatrixToImageWriter.writeToFile(byteMatrix, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	public static void main(String[] args) throws Exception{
		new QRCodeDemo().create();
	}
}

package meetingroom.spring.dao;

import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.io.OutputStream;

public class GeneratePdfDao {

    public static void create(OutputStream os, String roomName ) throws FileNotFoundException {

        PdfWriter writer = new PdfWriter((os));
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        document.add(new Paragraph(roomName).setBold());

        String url = "http://localhost:8081/MeetingRoom/admin/form/" + roomName;
        BarcodeQRCode qrcode = new BarcodeQRCode(url);
        Image image = new Image(qrcode.createFormXObject(pdfDoc));
        image.setMinHeight(150.F);
        document.add(image);

        document.close();
        System.out.println("PDF Created");
    }

}

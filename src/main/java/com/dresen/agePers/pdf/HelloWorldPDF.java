package com.dresen.agePers.pdf;

import com.dresen.agePers.region.Region;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
public class HelloWorldPDF {

    private static Logger logger = LoggerFactory.
            getLogger(HelloWorldPDF.class);

    public static ByteArrayInputStream employeePDFReport
            (List<Region> regionList) {

        Document              document = new Document();
        ByteArrayOutputStream out      = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            // Add Text to PDF file ->
            Font font = FontFactory
                    .getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Paragraph para = new Paragraph("Employee Table", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(3);
            // Add PDF Table Header ->
            Stream.of("ID", "Nom", "Code")
                    .forEach(headerTitle ->
                             {
                                 PdfPCell header = new PdfPCell();
                                 Font headFont = FontFactory.
                                         getFont(FontFactory.HELVETICA_BOLD);
                                 header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                                 header.setHorizontalAlignment(Element.ALIGN_CENTER);
                                 header.setBorderWidth(2);
                                 header.setPhrase(new Phrase(headerTitle, headFont));
                                 table.addCell(header);
                             });

            for (Region region : regionList) {
                PdfPCell idCell = new PdfPCell(new Phrase(region.getId().
                                                                  toString()));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);

                PdfPCell nomCell = new PdfPCell(new Phrase
                                                        (region.getNom()));
                nomCell.setPaddingLeft(4);
                nomCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nomCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(nomCell);

                PdfPCell codeCell = new PdfPCell(new Phrase
                                                         (String.valueOf(region.getCode())));
                codeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                codeCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                codeCell.setPaddingRight(4);
                table.addCell(codeCell);
            }
            document.add(table);

            document.close();
        } catch (DocumentException e) {
            logger.error(e.toString());
        }

        return new ByteArrayInputStream(out.toByteArray());
    }


}

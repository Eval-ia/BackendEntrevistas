package com.evalia.backEntrevistasInformes.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.preguntas.PreguntaRespuestaDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PdfGeneratorService {

    public String generarPdf(EntrevistaEntity entrevista, List<PreguntaRespuestaDTO> respuestas){

        // String directorio = "informes";
        // new File(directorio).mkdirs();
        String fileName = "informes/entrevista_"+entrevista.getIdEntrevista()+" .pdf";

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            document.open();

            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font seccionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
            Font preguntaFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Font respuestaFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.ITALIC);

            
            document.add(new Paragraph("Resumen de la Entrevista", tituloFont));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Entrevistador: " + entrevista.getEntrevistador().getNombre()));
            document.add(new Paragraph("Candidato: " + entrevista.getCandidato().getNombre()));
            document.add(new Paragraph("Puesto: " + entrevista.getPuesto().getNombre()));
            document.add(new Paragraph("Fecha: " + entrevista.getFecha()));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Respuestas:", seccionFont));
            document.add(new Paragraph(" "));

            for(PreguntaRespuestaDTO r : respuestas){
                String pregunta = r.getIdPregunta() != null ?
                "Pregunta  " + r.getLabel() :
                "Pregunta personalizada" + r.getTextoPreguntaPersonalizada();
                document.add(new Paragraph(pregunta,preguntaFont));
                document.add(new Paragraph("Respuesta: " + r.getRespuesta(),respuestaFont));
                document.add(new Paragraph(" "));
            }

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}

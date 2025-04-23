package br.com.mangarosa.mangarosa.collections;

import javax.sound.sampled.*;
import java.io.File;

public class ReprodutorLista {

    public static void reproduzir(String caminhoArquivo) {
        try {
            File arquivo = new File(caminhoArquivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception e) {
            System.out.println("Erro ao reproduzir o áudio: " + e.getMessage());
        }
    }
}

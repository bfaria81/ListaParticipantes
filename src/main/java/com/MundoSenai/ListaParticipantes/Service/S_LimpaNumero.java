package com.MundoSenai.ListaParticipantes.Service;

import org.springframework.stereotype.Service;

@Service
public class S_LimpaNumero {
    public static String limpar(String numero){
        //Remove caracteres não numéricos
        return numero.replaceAll("[^0-9]", "");
    }

}

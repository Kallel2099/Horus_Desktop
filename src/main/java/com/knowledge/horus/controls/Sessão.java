package com.knowledge.horus.controls;

public final class Sessão {
    
    private static Sessão instance;
    private static String logado;
    private static String nivel;
    private static byte[] foto;

    public static String getLogado() {
        return logado;
    }

    public static void setLogado(String aLogado) {
        logado = aLogado;
    }
    
    public static String getNivel() {
        return nivel;
    }

    public static void setNivel(String aNivel) {
        nivel = aNivel;
    }

    public static byte[] getFoto() {
        return foto;
    }

    public static void setFoto(byte[] aFoto) {
        foto = aFoto;
    }
    
    public Sessão(){
    }
    
    public static synchronized Sessão getInstance(){
        if (instance == null) {
            instance = new Sessão();
        }
        return instance;
    }
}

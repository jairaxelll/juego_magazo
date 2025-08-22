
package retofinal;

public class Jugador {
    
    public int casas;
    public int jnumhadas;
    public String escudo;
    public int jpoder;
    
    
    Jugador(int casas, int jnumhadas, String escudo, int jpoder){
        this.casas = casas;
        this.jnumhadas = jnumhadas;
        this.escudo = escudo;
        this.jpoder = jpoder;
    }
    
    public int getcasas(){
        return casas;
    }
    
    public void setcasas(int casas){
    this.casas = casas;
    }

    public int getjnumhadas(){
        return jnumhadas;
    }
    
    public void setjnumhadas(int jnumhadas){
    this.jnumhadas = jnumhadas;
    }

    public String getescudo(){
        return escudo;
    }
    
    public void setescudo(String escudo){
    this.escudo = escudo;
    }

    public int getjpoder(){
        return jpoder;
    }
    
    public void setjpoder(int jpoder){
    this.jpoder = jpoder;
    }    

    }
    

public class Musica{
    private double duraçao;
    private Campo campo;
    private String[] listaArtistas;
    private String titulo;
    private String genero;
    private String nomeGravadora;
    
    public Musica(String titulo, String genero, String nomeGravadora, 
                  String[] listaArtistas, Campo campo, double duraçao){
                      this.setTitulo(titulo);
                      this.setGenero(genero);
                      this.setNomeGravadora(nomeGravadora);
                      this.setListaArtistas(listaArtistas);
                      this.setCampo(campo);
                      this.setDuraçao(duraçao);
    };
    
    private void setTitulo(String titulo){
        this.titulo = titulo;  
    };
    
    private void setGenero(String genero){
        this.genero = genero;
    };
    
    private void setNomeGravadora(String nomeGravadora){
        this.nomeGravadora = nomeGravadora; 
    };
    
    private void setListaArtistas(String[] listaArtistas){
        this.listaArtistas = listaArtistas; 
    };
    
    private void setCampo(Campo campo){
        this.campo = campo; 
    };
    
    private void setDuraçao(double duraçao){
        this.duraçao = duraçao; 
    };
   
    public String getTitulo(){
        return this.titulo;
    };
    
    public String getGenero(){
        return this.genero;
    };
    
    public String getNomeGravadora(){
        return this.nomeGravadora;
    };
    
    public String[] getListaArtistas(){
        return this.listaArtistas;
    };
    
    public Campo getCampo(){
        return this.campo;
    };
    
    public double getDuraçao(){
        return this.duraçao;
    };
    
    public boolean comparar(String[] outraLista){
        int count=0;
        
        for(String artistas : this.listaArtistas){
            for(String artistas2 : outraLista){
                if(artistas.equals(artistas2))
                    count++;
            }
        }
        
        if(count == this.listaArtistas.length){
            return true;
        }else{
            return false;
        }
    };
    
    public boolean equals(Musica outra){
        if(!(this.getTitulo().equals(outra.getTitulo()))){
            return false;
        }else if(this.comparar(outra.listaArtistas) && outra.comparar(this.listaArtistas))
            return true;
            else return false;
    }; 
    
    public float calcularProximidade(Musica outra){
        float proximidade = 0f;
        
        if(this.getCampo() == outra.getCampo())
            proximidade += 1f;
        if(this.getNomeGravadora().equals(outra.getNomeGravadora()))
            proximidade += 1f;
        if(this.getGenero().equals(outra.getGenero()))
            proximidade += 1f;
        if(this.equals(outra)){
            proximidade += 1f;
        }else{
            proximidade += this.calcularPorcentagem(outra);
        }
        return proximidade;
    };   
    
    private float calcularPorcentagem(Musica outra){
          float qtdArtistas = this.listaArtistas.length + outra.listaArtistas.length;
            float artistasCoincidentes = this.compararCount(outra.listaArtistas) + outra.compararCount(this.listaArtistas);
          
          return qtdArtistas/artistasCoincidentes;
    };
    
    public float compararCount(String[] outraLista){
        int count=0;
        
        for(String artistas : this.listaArtistas){
            for(String artistas2 : outraLista){
                if(artistas == artistas2)
                    count++;
            }
        }
        return count; 
    };  
}
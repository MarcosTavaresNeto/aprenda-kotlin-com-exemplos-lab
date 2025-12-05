// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)


//TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")

/********************************************************************/
/* Classe Nível, utilizada apenas para informar o Nível do Conteúdo */

enum class Nivel { 	BASICO,INTERMEDIARIO,AVANCADO }

/*********************************************************************/



/*********************************************************************/
/*Classe Usuário Utilizada para cadastrar o Nome e Status do Usuário**/
class Usuario(val nomeUsuario: String, var ativo : Boolean){
    
    fun imprimeUsuario(){
        val atv = if (ativo) "Sim" else "Nao"       
        println("Nome do Usuario: ${this.nomeUsuario}");
    	println("Ativo: ${atv}");
        println("-----");
    }
    
}
/*********************************************************************/


/*********************************************************************/
/***** Classe ConteudoEducacional Utilizada para cadastrar ***********/ 
/*********** os conteúdos do curso com seu nível e duração ***********/
 
data class ConteudoEducacional(val nomeCurso: String,val duracaoHoras: Int,val nivel : Nivel)
{
    fun imprimeConteudo()
    {
        println("Curso: ${this.nomeCurso}");
    	println("Duração: ${this.duracaoHoras} hora (s)");
    	println("Nível: ${this.nivel}");
        println("-----");
    }
}

/********************************************************************/
/* Classe Formacao Classe Principal, Utilizada para matricular o ****/
/** o usuário e informar estes assim como os conteúdos da formação **/
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nomeUsuario} matriculado com sucesso!")
        println("-----");
    }
    fun imprimeUsuario() {
            if (inscritos.isEmpty()) {
                println("Nenhum usuário matriculado ainda.")
                println("-----");
                return
            }

            println("Usuários matriculados na formação '$nome':")
            println("-----");
            inscritos.forEach { usuario ->
                usuario.imprimeUsuario()
            }
        }

	fun listarConteudos() {
        if (this.conteudos.isEmpty()) {
            println("Nenhum conteúdo disponível para esta formação.")
            println("-----");
            return
        }

        println("Conteúdos da formação '$nome':")
        this.conteudos.forEach { conteudo ->
            conteudo.imprimeConteudo();
            
        }
    }
}


/********************************************************************/




/********************************************************************/
/**********************Chamada das classes:**************************/
//TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

fun main() {
      
    val iesna = ConteudoEducacional(
    nomeCurso = "Introdução a Experiência e Sistemas Natívos Android",
    duracaoHoras = 1,
    nivel = Nivel.BASICO
	);
    val ckdo = ConteudoEducacional(
    nomeCurso = "Conhecendo o Kotlin e sua Documentação Oficial ",
    duracaoHoras = 1,
    nivel = Nivel.BASICO
	);
    val tec = ConteudoEducacional(
    nomeCurso = "Tratamento de Exceções em Kotlin",
    duracaoHoras = 1,
    nivel = Nivel.INTERMEDIARIO
	);
   

    val mt = Usuario("Marcos Tavares",true);
    val pm = Usuario("Paulo Marcio",true);
    val af = Usuario("Aline Fontes",true);

    
    val KotlinBasico = Formacao("Formação em Kotlin 2025",listOf(iesna, ckdo, tec));
    
    KotlinBasico.matricular(mt);
    KotlinBasico.matricular(pm);
    KotlinBasico.matricular(af);
    KotlinBasico.imprimeUsuario();
    KotlinBasico.listarConteudos();     

}
package pe.com.novatronic;


public class TennisGame {

	private int puntajeJugadorUno = 0;
	private int puntajeJugadorDos = 0;
	private String nombreJugadorDos;
	private String nombreJugadorUno;
	
	public TennisGame(String playerOneName, String playerTwoName) {
		this.nombreJugadorUno = playerOneName;
		this.nombreJugadorDos = playerTwoName;
	}

	public String obtenerPuntaje() {

		if (hasWinner()) {
			return playerWithHighestScore() + " wins";
		}
		
		if (hasAdvantage()) { 
			return "Advantage " + playerWithHighestScore(); 
		}
		
		if (isDeuce())
			return "Deuce";
		
		if(puntajeJugadorUno == puntajeJugadorDos) {
			return descripcionPuntos(puntajeJugadorUno) + " all";
		}
		
		return descripcionPuntos(puntajeJugadorUno) + "," + descripcionPuntos(puntajeJugadorDos);
	}

	private boolean isDeuce() {
		return puntajeJugadorUno >= 3 && puntajeJugadorDos == puntajeJugadorUno;
	}
	
	private String playerWithHighestScore() {
		if (puntajeJugadorUno > puntajeJugadorDos) {
			return nombreJugadorUno;
		} else {
			return nombreJugadorDos;
		}
	}
	
	private boolean hasWinner() {
		if(puntajeJugadorDos >= 4 && puntajeJugadorDos >= puntajeJugadorUno + 2 )
			return true;
		if(puntajeJugadorUno >= 4 && puntajeJugadorUno >= puntajeJugadorDos + 2)
			return true;
		return false;
	}
	
	private boolean hasAdvantage() {
		if (puntajeJugadorDos >= 4 && puntajeJugadorDos == puntajeJugadorUno + 1)
			return true;
		if (puntajeJugadorUno >= 4 && puntajeJugadorUno == puntajeJugadorDos + 1)
			return true;
		
		return false;

	}

	public void playerOneScores() {
		puntajeJugadorUno++;
	}

	public void playerTwoScores() {
		puntajeJugadorDos++;
	}
	
	private String descripcionPuntos(int puntaje) {
		switch (puntaje) {
		case 3:
			return "Forty";
		case 2:
			return "Thirty";
		case 1: 
			return "Fifteen";
		case 0:
			return "Love";
		}
		throw new IllegalArgumentException("Puntaje Ilegal: " + puntaje);
	}
}

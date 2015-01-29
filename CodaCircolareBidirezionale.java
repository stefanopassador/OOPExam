public class CodaCircolareBidirezionale<E> {
	NodoCoda<E> inizio;

	public CodaCircolareBidirezionale(E[] dati) {
		for (int i = 0; i < dati.length; i++) {
			inserisci(dati[i]);
		}
	}

	public void inserisci(E x) {
		if (inizio == null) {
			inizio = new NodoCoda<E>(x);
			inizio.setPuntaDx(inizio);
			inizio.setPuntaSx(inizio);
		} else {
			inserisci(x, inizio);
		}
	}
	public void inserisci (E x, NodoCoda<E> nodoAttuale) {
		if (nodoAttuale.getPuntaDx() == inizio) {
			nodoAttuale.setPuntaDx(new NodoCoda<E>(x, nodoAttuale, inizio));
			inizio.setPuntaSx(nodoAttuale.getPuntaDx());
		} else {
			inserisci(x, nodoAttuale.getPuntaDx());
		}
	}

	public void ruotaOrario(int n) {
		for (int i = 0; i < n; i++) {
			inizio = inizio.getPuntaDx();
		}
	}
	public void ruotaAntiorario(int n) {
		for (int i = 0; i < n; i++) {
			inizio = inizio.getPuntaSx();
		}
	}

	public E leggi() {
		return inizio.getDato();
	}
	public void sovrascrivi(E dato) {
		inizio.setDato(dato);
	}

	public boolean trova(E x) {
		if (inizio == null) {
			return false;
		} else {
			return trova(x, inizio);
		}
	}
	public boolean trova(E x, NodoCoda<E> nodoAttuale) {
		if (nodoAttuale.getDato() == x) {
			inizio = nodoAttuale;
			return true;
		} else if (nodoAttuale.getPuntaDx() == inizio) {
			return false;
		} else {
			return trova(x, nodoAttuale.getPuntaDx());
		}
	}

	public String toString(String separatore, boolean direzione) {
		return toString(separatore, direzione, new NodoCoda<E>(inizio));
	}
	public String toString(String separatore, boolean direzione, NodoCoda<E> nodoAttuale) {
		if (nodoAttuale != inizio) {
			String s = nodoAttuale.getDato() + "";
			if (direzione) {
				if (nodoAttuale.getPuntaDx() != inizio) {
					s = s + separatore;
				}
				return s + toString(separatore, direzione, nodoAttuale.getPuntaDx());
			} else {
				if (nodoAttuale.getPuntaSx() != inizio) {
					s = s + separatore;
				}
				return s + toString(separatore, direzione, nodoAttuale.getPuntaSx());
			}
		} else {
			return "";
		}
	}
}
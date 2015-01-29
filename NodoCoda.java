public class NodoCoda<E> {
	E dato;
	NodoCoda<E> puntaSx, puntaDx;

	public NodoCoda(E x) {
		dato = x;
		puntaDx = null;
		puntaSx = null;
	}
	public NodoCoda(NodoCoda<E> nodo) {
		dato = nodo.getDato();
		puntaSx = nodo.getPuntaSx();
		puntaDx = nodo.getPuntaDx();
	}
	public NodoCoda(E x, NodoCoda<E> sx, NodoCoda<E> dx) {
		dato = x;
		puntaSx = sx;
		puntaDx = dx;
	}
	public E getDato(){ return dato; }
	public NodoCoda<E> getPuntaDx() {return puntaDx;}
	public NodoCoda<E> getPuntaSx() {return puntaSx;}

	public void setDato(E x){dato = x;}
	public void setPuntaDx(NodoCoda<E> dx) {
		puntaDx = dx;
	}
	public void setPuntaSx(NodoCoda<E> sx) {
		puntaSx = sx;
	}

}
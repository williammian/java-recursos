package br.com.wm.nf.util;

import java.util.concurrent.SubmissionPublisher;

import br.com.wm.modelo.dominio.NotaFiscal;
import br.com.wm.nf.subscriber.NotaFiscalSubscriber;

public class NotaFiscalUtil {

	private SubmissionPublisher<NotaFiscal> publisher;

	public NotaFiscalUtil() {
		this.publisher = new SubmissionPublisher<NotaFiscal>();
		this.publisher.subscribe(new NotaFiscalSubscriber());
	}

	public void emitir(NotaFiscal nf) {
		this.publisher.submit(nf);
	}

	public void fechar() {
		this.publisher.close();
	}
}

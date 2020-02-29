package pers.bo.zhao.mydubbo.rpc.protocol;

import pers.bo.zhao.mydubbo.rpc.Exporter;
import pers.bo.zhao.mydubbo.rpc.Invoker;

public abstract class AbstractExporter<T> implements Exporter<T> {

    private final Invoker<T> invoker;

    private volatile boolean unexported = false;


    public AbstractExporter(Invoker<T> invoker) {
        if (invoker == null)
            throw new IllegalStateException("service invoker == null");
        if (invoker.getInterface() == null)
            throw new IllegalStateException("service type == null");
        if (invoker.getUrl() == null)
            throw new IllegalStateException("service url == null");
        this.invoker = invoker;
    }

    @Override
    public Invoker<T> getInvoker() {
        return invoker;
    }

    @Override
    public void unexport() {
        if (unexported) {
            return;
        }
        unexported = true;
        getInvoker().destroy();
    }

    @Override
    public String toString() {
        return getInvoker().toString();
    }
}

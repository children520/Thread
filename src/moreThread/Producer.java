package moreThread;

public class Producer {
	private String producer;
    private Storage storage;

    public Producer(Storage storage)
    {
        this.storage = storage;
    }

    public void run()
    {
        produce(producer);
    }

    public void produce(String producer)
    {
        storage.produce(producer);
    }

    public String getProducer()
    {
        return producer;
    }

    public void setProducer(String producer)
    {
        this.producer = producer;
    }

    public Storage getStorage()
    {
        return storage;
    }

    public void setStorage(Storage storage)
    {
        this.storage = storage;
    }
}

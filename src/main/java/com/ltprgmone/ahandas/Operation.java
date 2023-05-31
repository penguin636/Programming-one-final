public class Operation{
    private Contract contract;
    private Building building;
    private int progress;
    private int opposition;

    public Operation(Contract inProgressC, Building inProgressB,int progressClock, int oppositionCLock)
    {
        contract=inProgressC;
        building=inProgressB;
        progress=progressCLock;
        opposition=oppositionClock;
    }
}
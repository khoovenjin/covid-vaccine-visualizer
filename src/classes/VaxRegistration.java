package classes;

public class VaxRegistration<T,U,V> {
    private T date; // LocalDate
    private U state; // String
    private V total,phase2,mysj,call,web,children,children_solo,adolescents,elderly,comorb,oku; // int/Integer/Long/Numbers etc.

    public VaxRegistration (T date, U state, V total, V phase2, V mysj, V call, V web, V children, V children_solo,
                    V adolescents, V elderly, V comorb, V oku) {
        this.date = date;
        this.state = state;
        this.total = total;
        this.phase2 = phase2;
        this.mysj = mysj;
        this.call = call;
        this.web = web;
        this.children = children;
        this.children_solo = children_solo;
        this.adolescents = adolescents;
        this.elderly = elderly;
        this.comorb = comorb;
        this.oku = oku;
    }

    public T getDate () {
            return date;
    }

    public U getState () {
            return state;
    }

    public V getTotal () {
            return total;
    }

    public V getPhase2 () {
            return phase2;
    }

    public V getMysj () {
            return mysj;
    }

    public V getCall () {
            return call;
    }

    public V getWeb () {
            return web;
    }

    public V getChildren () {
            return children;
    }

    public V getChildrenSolo () {
            return children_solo;
    }

    public V getAdolescents () {
            return adolescents;
    }

    public V getElderly () {
            return elderly;
    }

    public V getComorb () {
            return comorb;
    }

    public V getOku () {
            return oku;
    }

    public void setDate (T date) {
            this.date = date;
    }

    public void setState (U state) {
            this.state = state;
    }

    public void setTotal (V total) {
            this.total = total;
    }

    public void setPhase2 (V phase2) {
            this.phase2 = phase2;
    }

    public void setMysj (V mysj) {
            this.mysj = mysj;
    }

    public void setCall (V call) {
            this.call = call;
    }

    public void setWeb (V web) {
            this.web = web;
    }

    public void setChildren (V children) {
            this.children = children;
    }

    public void setChildrenSolo (V children_solo) {
            this.children_solo = children_solo;
    }

    public void setAdolescents (V adolescents) {
            this.adolescents = adolescents;
    }

    public void setElderly (V elderly) {
            this.elderly = elderly;
    }

    public void setComorb (V comorb) {
            this.comorb = comorb;
    }

    public void setOku (V oku) {
            this.oku = oku;
    }
}

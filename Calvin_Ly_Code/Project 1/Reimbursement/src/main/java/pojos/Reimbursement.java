package pojos;

import java.sql.Timestamp;

public class Reimbursement{
    private int id;
    private double amount;
    private Timestamp time_submitted;
    private Timestamp time_resolved;
    private String description;
    private int author_id;
    private int resolver_id;
    private int status_id;
    private int type_id;
    private String author_fn;
    private String author_ln;
    private String resolver_ln;
    private String status;
    private String type;

    public Reimbursement() {}

    public Reimbursement(double amount, String description, int type_id) {
        super();
        this.amount = amount;
        this.description = description;
        this.type_id = type_id;
    }

    public Reimbursement(int id, int resolver_id, int status_id) {
        this.id = id;
        this.resolver_id = resolver_id;
        this.status_id = status_id;
    }

    public Reimbursement(double amount, Timestamp time_submitted, Timestamp time_resolved, String description,
                         int author_id, int resolver_id, int status_id, int type_id) {
        super();
        this.amount = amount;
        this.time_submitted = time_submitted;
        this.time_resolved = time_resolved;
        this.description = description;
        this.author_id = author_id;
        this.resolver_id = resolver_id;
        this.status_id = status_id;
        this.type_id = type_id;
    }

    public Reimbursement(double amount, Timestamp time_submitted, Timestamp time_resolved, String description,
                         String resolver_ln, String status, String type) {
        super();
        this.amount = amount;
        this.time_submitted = time_submitted;
        this.time_resolved = time_resolved;
        this.description = description;
        this.resolver_ln = resolver_ln;
        this.status = status;
        this.type = type;
    }

    public Reimbursement(double amount, Timestamp time_submitted, Timestamp time_resolved, String description,
                         String author_fn, String author_ln, String resolver_ln, String status, String type,
                         int id, int resolver_id, int status_id) {
        super();
        this.amount = amount;
        this.time_submitted = time_submitted;
        this.time_resolved = time_resolved;
        this.description = description;
        this.author_fn = author_fn;
        this.author_ln = author_ln;
        this.resolver_ln = resolver_ln;
        this.status = status;
        this.type = type;
        this.id = id;
        this.resolver_id = resolver_id;
        this.status_id = status_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getTime_submitted() {
        return time_submitted;
    }

    public void setTime_submitted(Timestamp time_submitted) {
        this.time_submitted = time_submitted;
    }

    public Timestamp getTime_resolved() {
        return time_resolved;
    }

    public void setTime_resolved(Timestamp time_resolved) {
        this.time_resolved = time_resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getResolver_id() {
        return resolver_id;
    }

    public void setResolver_id(int resolver_id) {
        this.resolver_id = resolver_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getAuthor_fn() {
        return author_fn;
    }

    public void setAuthor_fn(String author_fn) {
        this.author_fn = author_fn;
    }

    public String getAuthor_ln() {
        return author_ln;
    }

    public void setAuthor_ln(String author_ln) {
        this.author_ln = author_ln;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResolver_ln() {
        return resolver_ln;
    }

    public void setResolver_ln(String resolver_ln) {
        this.resolver_ln = resolver_ln;
    };





}
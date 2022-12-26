package com.eikal.models.store.bank;

import java.sql.Timestamp;

public class Medicine {
    private int id;
    private String type;
    private String drugCode;
    private String name;
    private String state;
    private String description;
    private String CASNumber;
    private String proteinFormula;
    private String proteinWeight;
    private boolean investigational; //todo check type
    private boolean approved;
    private boolean vetApproved;
    private boolean experimental;
    private boolean nutraceutical;
    private boolean illicit;
    private String withdrawn;
    private String moldbMonoMass;
    private String moldbInchi;
    private String moldbInchikey;
    private String moldbSmiles;
    private String moldbAverageMass;
    private String moldbFormula;
    private String synthesisPatentId;
    private String proteinWeightDetail;
    private String biotechKid;
    private Timestamp dateCreated;
    private Timestamp dateModified;
}

export class Compte {
    id: number;
    login: string;
    password: string;

    constructor(id?:number, login?: string, password?: string) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
}

export class Inscription {
    id: number;
    login: string;
    mdp: string;
    choix: string;

    constructor(id?:number, login?: string, mdp?: string, choix?: string) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.choix = choix;
    }
}

export class Visite {
    id: number;
    prix: number;
    dateVisite: string;
    medecin : Medecin = new Medecin();
    patient : Patient = new Patient();

    constructor(id?:number, prix?: number, dateVisite?: string) {
        this.id = id;
        this.prix = prix;
        this.dateVisite = dateVisite;
    }
}

export class Patient {
    id: number;
    numeroSecuriteSociale: string;
    nom: string;
    prenom : string;

    constructor(id?:number, numeroSecuriteSociale?: string, nom?: string, prenom?: string) {
        this.id = id;
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.nom = nom;
        this.prenom = prenom;
    }
}

export class Medecin {
    visites : Array<Visite> = new Array<Visite>;

    constructor() {
    }
}

export class Secretaire {

    constructor() {
    }
}
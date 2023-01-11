export class Matiere {
    id: number;
    libelle: string;
    quest: number;
    version: number;

    constructor(id?:number, libelle?: string, quest?: number, version?: number) {
        this.id = id;
        this.libelle = libelle;
        this.quest = quest;
        this.version = version;
    }
}

export class Filiere {
    id: number; 
	version: number;
    libelle: string;
    debut: string;
    fin: string;
 
    constructor(id?:number, version?: number , libelle?: string, debut?: string, fin? :string) {
        this.id = id;
        this.version = version;
        this.libelle = libelle;
        this.debut = debut;
        this.fin = fin;
    }
}

export class Stagiaire {
    id: number; 
	version: number;
    nom: string;
    prenom: string;
    email: string;
    filiere: Filiere;
 
    constructor(id?:number, version?: number , nom?: string, prenom?: string, email? :string, filiere?: Filiere) {
        this.id = id;
        this.version = version;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.filiere = filiere;
    }
}

export class Ordinateur {
    id: number; 
	version: number;
    marque: string;
    ram: number;
    email: string;
 
    constructor(id?:number, version?: number , marque?: string, ram?: number) {
        this.id = id;
        this.version = version;
        this.marque = marque;
        this.ram = ram;
    }
}
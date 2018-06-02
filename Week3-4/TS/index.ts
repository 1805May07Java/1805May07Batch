function hello(greeting: string, someone:string){
    return `${greeting}, we are greeting you ${someone}!`;
}
document.body.innerHTML = hello("HEY", "GB");




// Typescript allows us to use both interfaces and classes
interface Human{
    name: string;
    //optional properties
    age?: number;
    speak(): void;
}

let hum: Human = {name: "Gen", age: 60, speak: () => {console.log("hay")}};
console.log(hum);

//CLASSES
class Point{
    x: number;
    y: number;

    constructor(x: number, y:number){
        this.x = x;
        this.y = y;
    }

    //function getDistance(){ // in classes in TS, "functions" are no longer functions, they are methods

    getDistance(){
        return Math.sqrt(this.x*this.x + this.y*this.y);
    } 
}

//inheritance 
class Point3D extends Point{
    z: number;

    constructor(x: number, y:number, z: number){
        super(x, y);
        this.z = z;
    }

    //overwriting
    getDistance(){
        let dist = super.getDistance();
        return Math.sqrt(dist*dist + this.z*this.z);
    }
}



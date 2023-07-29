
export interface Assignment{
    id:number;
    courseId:number;
    instructorId:number;
    assignmentName:string;
    postedDate:Date;
    dueDate:Date;
}

export class AssignmentQuestion{
    id:number=0;
    assignmentId:number=0;
    question:string='';
    options:string[]=[];
    answer:string='';
    constructor(question:string,options:string[],answer:string){
        this.question=question;
        this.options=options;
        this.answer=answer
    }
}

export interface CompletedAssignmentData{
    id:number;
    assignmentId:number;
    instructorId:number;
    courseId:number;
    userId:number;
    marksObtained:number;
    assignmentName:string;
}

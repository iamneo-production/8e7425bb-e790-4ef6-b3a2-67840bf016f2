import { Component } from '@angular/core';

@Component({
  selector: 'app-helpnsupport',
  templateUrl: './helpnsupport.component.html',
  styleUrls: ['./helpnsupport.component.css']
})
export class HelpnsupportComponent {
  isSubmitted=false;
  star1 = "bi-star";
  star2 = "bi-star";
  star3 = "bi-star";
  star4 = "bi-star";
  star5 = "bi-star";
  rating_text = "Rate us"
  onclick(rating:number){
    if(rating===1){
      this.star1="bi-star-fill";
      this.star2 = "bi-star";
      this.star3 = "bi-star";
      this.star4 = "bi-star";
      this.star5 = "bi-star";
      this.rating_text = "poor";
    }
    else if(rating===2){
      this.star1="bi-star-fill";
      this.star2="bi-star-fill";
      this.star3 = "bi-star";
      this.star4 = "bi-star";
      this.star5 = "bi-star";
      this.rating_text = "satisfactory";
    }
    else if(rating===3){
      this.star1="bi-star-fill";
      this.star2="bi-star-fill";
      this.star3 = "bi-star-fill";
      this.star4 = "bi-star";
      this.star5 = "bi-star";
      this.rating_text = "good";
    }
    else if(rating===4){
      this.star1="bi-star-fill";
      this.star2="bi-star-fill";
      this.star3 = "bi-star-fill";
      this.star4 = "bi-star-fill";
      this.star5 = "bi-star";
      this.rating_text = "very good";
    }
    else if(rating===5){
      this.star1="bi-star-fill";
      this.star2="bi-star-fill";
      this.star3 = "bi-star-fill";
      this.star4 = "bi-star-fill";
      this.star5 = "bi-star-fill";
      this.rating_text = "excellent";
    }
  }

  onSubmit(){
    this.isSubmitted=true;
  }
}

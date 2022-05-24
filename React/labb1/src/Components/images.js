
import { clear } from "@testing-library/user-event/dist/clear";
import { Component } from "react";
import "./component.css";

class ImageSlider extends Component {


    images = ['./sea.png', './sand.png', './sea2.png'];
    index = 0;
    Interval = null;

    constructor() {
        super();
        this.state = {
            img: "./sea.png"
        }
    }

    slideLeft = () => {
        if (this.index > 0) {
            this.index--;
            this.setState({ img: this.images[this.index] })
            clearInterval(this.Interval);
        }
    }


    slideRight = () => {
        if (this.index < this.images.length - 1) {
            this.index++;
            this.setState({ img: this.images[this.index] })
            clearInterval(this.Interval);
        }
    }

    slide = ()=>{
        this.Interval = setInterval(this.Start, 1000);
    }

    Start = () => {
        if(this.index<this.images.length-1){
            this.index++;
            this.setState({ img: this.images[this.index]});
        }else{
            this.index = 0;
            this.setState({ img: this.images[this.index]});
        }
    }

    stopSlide = ()=>{
        clearInterval(this.Interval);
        }


    render() {
        return (
            (
                <div >
                    <a href="#" onClick={this.slideLeft}>&#8249;</a>
                    <img src={this.state.img} alt={this.index} style={{ width: '700px', height: '500px' }} />
                    <a href="#" onClick={this.slideRight}>&#8250;</a> 
                    <div class="img">
                    <a href="#" class="start" onClick={this.slide}>{"Start"}</a> 
                    <a href="#" onClick={this.stopSlide}>{"Stop"}</a> 
                    </div>
                </div>
            )

        )
    }
}
export default ImageSlider;
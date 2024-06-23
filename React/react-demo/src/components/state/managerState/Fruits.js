import React from 'react';
import FruitsName from "./FruitsName";
import FruitsCounter from "./FruitsCounter";


export default function Fruits() {
    const [Fruits] = React.useState([
        {fruitName: "apple", id: 1},
        {fruitName: "plum", id: 2},
        {fruitName: "banana", id: 3},
    ]);

    return (
        <div>
            <h1>Where should the state go?</h1>
            <FruitsName fruits={Fruits} />
            <FruitsCounter fruits={Fruits} />
        </div>
    )
}

import {useState} from "react";

export default function Input(){
    const [inputText, setInputText] = useState('hello');

    function handleChange(e){
        setInputText(e.target.value);
    }

    return (
        <div>
            <input value={inputText} onChange={handleChange} />
            <p>You typed: {inputText}</p>
            <button onClick={() => setInputText('hello')}>
                Reset
            </button>
        </div>
    )
}

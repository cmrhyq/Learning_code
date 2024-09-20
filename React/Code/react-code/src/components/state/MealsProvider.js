import React from 'react';

const MealsContext = React.createContext();

const todayMeals = ["Baked Beans", "Baked Sweet Potatoes", "Baked Potatoes"]

const MealsProvider = ({children}) => {
    const [meals, setMeals] = React.useState(todayMeals);

    return (
        <MealsContext.Provider value={{meals, setMeals}}>
            {children}
        </MealsContext.Provider>
    )
}

export const useMealsListContext = () => React.useContext(MealsContext);

export default MealsProvider

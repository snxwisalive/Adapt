export default function StepTwo({ formData, onInputChange, onBack, onRegister }) {
    return (
        <form className="registerForm" onSubmit={onRegister}>
            <div className="formGroup">
                <label htmlFor="age">Age</label>
                <input
                    id="age"
                    name="age"
                    type="number"
                    placeholder="18"
                    min="1"
                    value={formData.age}
                    onChange={onInputChange}
                    required
                />

                <label htmlFor="height">Height</label>
                <input
                    id="height"
                    name="height"
                    type="number"
                    placeholder="175"
                    min="1"
                    value={formData.height}
                    onChange={onInputChange}
                    required
                />

                <label htmlFor="weight">Weight</label>
                <input
                    id="weight"
                    name="weight"
                    type="number"
                    placeholder="80"
                    min="1"
                    value={formData.weight}
                    onChange={onInputChange}
                    required
                />

                <label>Gender</label>
                <label htmlFor="genderMale">
                    <input
                        id="genderMale"
                        name="gender"
                        type="radio"
                        value="male"
                        checked={formData.gender === "male"}
                        onChange={onInputChange}
                        required
                    />
                    Male
                </label>
                <label htmlFor="genderFemale">
                    <input
                        id="genderFemale"
                        name="gender"
                        type="radio"
                        value="female"
                        checked={formData.gender === "female"}
                        onChange={onInputChange}
                        required
                    />
                    Female
                </label>

                <label>Activity Level</label>
                <label htmlFor="activitySedentary">
                    <input
                        id="activitySedentary"
                        name="activityLevel"
                        type="radio"
                        value="sedentary"
                        checked={formData.activityLevel === "sedentary"}
                        onChange={onInputChange}
                        required
                    />
                    Sedentary
                </label>
                <label htmlFor="activityLight">
                    <input
                        id="activityLight"
                        name="activityLevel"
                        type="radio"
                        value="light"
                        checked={formData.activityLevel === "light"}
                        onChange={onInputChange}
                        required
                    />
                    Light
                </label>
                <label htmlFor="activityModerate">
                    <input
                        id="activityModerate"
                        name="activityLevel"
                        type="radio"
                        value="moderate"
                        checked={formData.activityLevel === "moderate"}
                        onChange={onInputChange}
                        required
                    />
                    Moderate
                </label>
                <label htmlFor="activityActive">
                    <input
                        id="activityActive"
                        name="activityLevel"
                        type="radio"
                        value="active"
                        checked={formData.activityLevel === "active"}
                        onChange={onInputChange}
                        required
                    />
                    Active
                </label>
                <label htmlFor="activityVeryActive">
                    <input
                        id="activityVeryActive"
                        name="activityLevel"
                        type="radio"
                        value="veryActive"
                        checked={formData.activityLevel === "veryActive"}
                        onChange={onInputChange}
                        required
                    />
                    Very Active
                </label>

                <label>Goal</label>
                <label htmlFor="goalLoss">
                    <input
                        id="goalLoss"
                        name="goal"
                        type="radio"
                        value="loss"
                        checked={formData.goal === "loss"}
                        onChange={onInputChange}
                        required
                    />
                    Loss
                </label>
                <label htmlFor="goalMaintain">
                    <input
                        id="goalMaintain"
                        name="goal"
                        type="radio"
                        value="maintain"
                        checked={formData.goal === "maintain"}
                        onChange={onInputChange}
                        required
                    />
                    Maintain
                </label>
                <label htmlFor="goalGain">
                    <input
                        id="goalGain"
                        name="goal"
                        type="radio"
                        value="gain"
                        checked={formData.goal === "gain"}
                        onChange={onInputChange}
                        required
                    />
                    Gain
                </label>

                <button type="button" onClick={onBack}>Back</button>
                <button name="register" type="submit">Register</button>
            </div>
        </form>
    );
}
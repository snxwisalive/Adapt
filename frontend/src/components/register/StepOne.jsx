export default function StepOne({ formData, onInputChange, onNext }) {
    return (
        <form className="registerForm" onSubmit={onNext}>
            <div className="formGroup">
                <label htmlFor="username">Username</label>
                <input
                    id="username"
                    name="username"
                    type="text"
                    placeholder="username"
                    value={formData.username}
                    onChange={onInputChange}
                    required
                />

                <label htmlFor="password">Password</label>
                <input
                    id="password"
                    name="password"
                    type="password"
                    placeholder="password"
                    value={formData.password}
                    onChange={onInputChange}
                    required
                />

                <label htmlFor="passwordConfirm">Confirm Password</label>
                <input
                    id="passwordConfirm"
                    name="passwordConfirm"
                    type="password"
                    placeholder="password"
                    value={formData.passwordConfirm}
                    onChange={onInputChange}
                    required
                />

                <button name="next" type="submit">Next</button>
            </div>
        </form>
    );
}
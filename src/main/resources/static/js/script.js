// Wait for the DOM to load
document.addEventListener('DOMContentLoaded', function () {
    // Find all forms on the page
    const forms = document.querySelectorAll('form');

    forms.forEach(form => {
        form.addEventListener('submit', function (e) {
            // Simple validation example: check required inputs are filled
            let valid = true;

            // Check all inputs with 'required' attribute
            form.querySelectorAll('[required]').forEach(input => {
                if (!input.value.trim()) {
                    valid = false;
                    input.classList.add('is-invalid');
                } else {
                    input.classList.remove('is-invalid');
                }
            });

            if (!valid) {
                e.preventDefault();
                alert('Please fill all required fields correctly.');
            }
        });

        // Remove 'is-invalid' class on input when user starts typing
        form.querySelectorAll('[required]').forEach(input => {
            input.addEventListener('input', () => {
                if (input.value.trim()) {
                    input.classList.remove('is-invalid');
                }
            });
        });
    });
});

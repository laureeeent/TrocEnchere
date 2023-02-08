/**
 * 
 */
 	$(function() {
	$('#mdp').hideShowPassword({
		show : false,
		innerToggle : 'focus',
		toggle : {
			className : 'hideShowPassword-toggle',
		},
		states : {
			shown : {
				className : 'hideShowPassword-shown',
				toggle : {
					className : 'hideShowPassword-toggle-hide',
					attr : {
						title : 'Cacher le MdP',
					}
				}
			},
			hidden : {
				className : 'hideShowPassword-hidden',
				toggle : {
					className : 'hideShowPassword-toggle-show',
					attr : {
						title : 'Montrer le MdP',
					}
				}
			}
		}
	});
	$('#mdp').on('passwordShown', function() {
		console.log('mot de passe visible');
	}).on('passwordHidden', function() {
		console.log('mot de passe invisible');
	});
});
	$(function() {
			$('#mdp1').hideShowPassword({
				show : false,
				innerToggle : 'focus',
				toggle : {
					className : 'hideShowPassword-toggle',
				},
				states : {
					shown : {
						className : 'hideShowPassword-shown',
						toggle : {
							className : 'hideShowPassword-toggle-hide',
							attr : {
								title : 'Cacher le MdP',
							}
						}
					},
					hidden : {
						className : 'hideShowPassword-hidden',
						toggle : {
							className : 'hideShowPassword-toggle-show',
							attr : {
								title : 'Montrer le MdP',
							}
						}
					}
				}
			});
			$('#mdp1').on('passwordShown', function() {
				console.log('mot de passe visible');
			}).on('passwordHidden', function() {
				console.log('mot de passe invisible');
			});
		});
			$(function() {
	$('#mdp2').hideShowPassword({
		show : false,
		innerToggle : 'focus',
		toggle : {
			className : 'hideShowPassword-toggle',
		},
		states : {
			shown : {
				className : 'hideShowPassword-shown',
				toggle : {
					className : 'hideShowPassword-toggle-hide',
					attr : {
						title : 'Cacher le MdP',
					}
				}
			},
			hidden : {
				className : 'hideShowPassword-hidden',
				toggle : {
					className : 'hideShowPassword-toggle-show',
					attr : {
						title : 'Montrer le MdP',
					}
				}
			}
		}
	});
	$('#mdp2').on('passwordShown', function() {
		console.log('mot de passe visible');
	}).on('passwordHidden', function() {
		console.log('mot de passe invisible');
	});
});

let achats = document.getElementById("achats");
let achat = document.getElementById("achat");
achats.addEventListener("mouseover", () => {achat.style.display = "block";});
achats.addEventListener("mouseout", () => {achat.style.display = "none";});

achats.onmouseover = aff;
function aff(){
  achat.style.display = "block";
}
achats.onmouseout = cac;
function cac(){
  achat.style.display = "none";
}
    